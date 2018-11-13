var mongoose = require('mongoose')

var PlaceSchema = new mongoose.Schema({
      nom: String,
      note: {
        type: Number,
        min: 0,
        max: 5
      },
      rank: Number,
      address: String,
      description: String,
      //review: {
      //  type: mongoose.Schema.Types.ObjectId,
      //  ref: 'UserReviewSchema'
      //}&
    });

// Export the model
module.exports = mongoose.model('Place', PlaceSchema)
