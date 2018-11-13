var mongoose = require('mongoose')
var TownSchema = new mongoose.Schema(
    {
      user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'UserSchema'
      },

    });

// Export the model
module.exports = mongoose.model('Town', TownSchema)
