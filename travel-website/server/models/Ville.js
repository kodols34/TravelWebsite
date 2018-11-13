var mongoose = require('mongoose')
var VilleSchema = new mongoose.Schema(
    {
      user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'UserSchema'
      },

    });

// Export the model
module.exports = mongoose.model('Ville', VilleSchema)
