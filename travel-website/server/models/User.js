var mongoose = require('mongoose')
var UserSchema = new mongoose.Schema({
        email: {
          type: String,
          unique: true,
          required: true
        },
        password: {
          type: String,
          required: true
        },
        // The pseudo is auto generated
        pseudo: {
          type: String,
          unique: true,
          required: false
        },
        nom: {
          type: String,
          required: true
        },
        prenom: {
          type: String,
          required: true
        },
        sexe: {
          type: String,
          required: true,
          enum: ['Men','Women']
        },
        age: {
          type: Number,
          required: true
        },
        phone: {
          type: String,
          validate: {
            validator: function(v) {
              return /\d{3}-\d{3}-\d{4}/.test(v);
            },
            message: props => `${props.value} is not a valid phone number!`
          },
          required: [true, 'User phone number required']
        },
        description: {
          type: String,
          default: "I really enjoy visiting new places"
        }
        //cration_date: String,

        //preferences: {
        //  type: mongoose.Schema.Types.ObjectId,
        //  ref: 'Ville'
        //}
    });

// Export the model
module.exports = mongoose.model('User', UserSchema)
