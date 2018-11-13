var mongoose = require('mongoose')
var UserSchema = new mongoose.Schema({
        pseudo: String,
        nom: String,
        prenom: String,
        //sexe: {
        //  type: String,
        //  enum: ['Homme','Femmme']
        //},
        age: Number,
        email: String,
        //phone: {
        //  type: String,
        //  validate: {
        //    validator: function(v) {
        //      return /\d{3}-\d{3}-\d{4}/.test(v);
        //    },
        //    message: props => `${props.value} is not a valid phone number!`
          //},
          //required: [true, 'User phone number required']
        //},
        description: String,
        //cration_date: String,

        //preferences: {
        //  type: mongoose.Schema.Types.ObjectId,
        //  ref: 'Ville'
        //}
    });

UserSchema.methods.follow = function (user_id) {
    if (this.following.indexOf(user_id) === -1) {
        this.following.push(user_id)
    }
    return this.save()
}
UserSchema.methods.addFollower = function (fs) {
    this.followers.push(fs)
}

// Export the model
module.exports = mongoose.model('User', UserSchema)
