'use strict';

const User = require('./../models/User');
const bcrypt = require('bcryptjs');

exports.registerUser = (email, password, nom, prenom, sexe, age, phone, description) =>

  new Promise((resolve,reject) => {

      const salt = bcrypt.genSaltSync(10);
		  const hash = bcrypt.hashSync(password, salt);

      const newUser = new User({

            email: email,
      		  hashed_password: hash,
            pseudo: nom,
            nom: nom,
            prenom: prenom,
            sexe: sexe,
            age: age,
            phone: phone,
            description: description,
      			created_at: new Date()

		  });

		newUser.save()

		.then(() => resolve({ status: 201, message: 'User Registered Sucessfully !' }))

		.catch(err => {
      console.log(err);
			if (err.code == 11000) {

				reject({ status: 409, message: 'User Already Registered !' });

			} else {

				reject({ status: 500, message: 'Internal Server Error !' });
			}
		});
	});
