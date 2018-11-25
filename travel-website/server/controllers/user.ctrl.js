const User = require('./../models/User')
const fs = require('fs')
const auth = require('basic-auth');
const jwt = require('jsonwebtoken');

const register = require('./../functions/register');
const login = require('./../functions/login');
const config = require('./../config/config.json');


module.exports = {
    /**
     * authenticate user
     */
    authenticateUser: (req, res, next) => {
        const credentials = auth(req);
        		if (!credentials) {
          			 res.status(400).json({ message: 'Invalid Request !' });
        		} else {
        			   login.loginUser(credentials.name, credentials.pass)

        		.then(result => {

        				 const token = jwt.sign(result, config.secret, { expiresIn: 1440 });

        				 res.status(result.status).json({ message: result.message, token: token });
        		})

        		.catch(err => res.status(err.status).json({ message: err.message }));
        		}
    },

    /**
     * get all users
     */
    getAll: (req, res, next) => {
      User.find({}, function(err, users) {
          var userMap = {};
          users.forEach(function(user) {
            userMap[user._id] = user;
          });
          res.send(userMap);
        });
    },

    /**
     * add an user
     */
    addUser: (req, res, next) => {
console.log(res.body);
        const email = req.body.email;
        const password = req.body.password;
        const nom = req.body.nom;
        const prenom = req.body.prenom;
        const sexe = req.body.sexe;
        const age = req.body.age;
        const phone = req.body.phone;
        // utile ?
        const description = req.body.description;

        if (!email || !password || !nom || !prenom || !sexe || !age || !phone ||
            !email.trim() || !password.trim() || !nom.trim() || !prenom.trim() ||
            !sexe.trim() || !age.trim() || !phone.trim()) {

        			res.status(400).json({message: 'Invalid Request !'});

        } else {

        			register.registerUser(email, password, nom, prenom, sexe, age, phone, description)

        			.then(result => {

                const token = jwt.sign(result, config.secret, { expiresIn: 1440 });

        				res.setHeader('Location', '/users/'+email);
        				res.status(result.status).json({ message: result.message, token: token })
        			})

        			.catch(err => res.status(err.status).json({ message: err.message }));
        		}

    },

    /**
     * get a particlular user to view
     */
    getUser: (req, res, next) => {
      //res.send('Greetings from the Test controller!');
      User.find({'email':req.params.id}, function (err, user) {
      //User.findById(req.params.id, function (err, user) {
        if (err) return next(err);
        res.send(user);
      })
    },

    /**
    * update a particlular user
    */
    updateUser: (req, res, next) => {
      console.log(req.body);
      User.findByIdAndUpdate(req.params.id, {$set: req.body}, function (err, user) {
        if (err) return next(err);
        res.send('Product udpated.');
      });
    },


    /**
    * delete a particlular user
    */
    deleteUser: (req, res, next) => {
      User.findByIdAndRemove(req.params.id, function (err) {
        if (err) return next(err);
        res.send('Deleted successfully!');
      });
    }
}
