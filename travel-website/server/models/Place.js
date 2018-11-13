var mongoose = require('mongoose')
var PlaceSchema = new mongoose.Schema({
      nom: {
        type: String,
        required: true
      },
      address: {
        type: String,
        required: true
      },
      description: String,
      note: {
        type: Number,
        min: 0,
        max: 5
      },
      rank: Number,
      //review: {
      //  type: mongoose.Schema.Types.ObjectId,
      //  ref: 'UserReviewSchema'
      //}&
    });

// Export the model
module.exports = mongoose.model('Place', PlaceSchema)
