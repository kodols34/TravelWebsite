const User = require('./../models/User')
const fs = require('fs')
module.exports = {

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
      let user = new User(
        {   pseudo: req.body.pseudo,
            nom: req.body.nom,
            prenom: req.body.prenom,
            sexe: req.body.sexe,
            age: req.body.age,
            email: req.body.email,
            phone: req.body.phone,
            description: req.body.description,
            //creation_date: req.body.creation_date,
            //preferences: req.body.preferences
        }
    );
    user.save(function (err) {
        if (err) {
            return next(err);
        }
        res.send(`User Created successfully ${user}`)
    })

    },

    /**
     * get a particlular user to view
     */
    getUser: (req, res, next) => {
      //res.send('Greetings from the Test controller!');
      User.findById(req.params.id, function (err, user) {
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
