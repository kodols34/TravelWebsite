var mongoose = require('mongoose')
var UserReviewSchema = new mongoose.Schema({
      user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'UserSchema'
      },
      note: {
        type: Number,
        min: 0,
        max: 5
      },
      place: String,
      title: String,
      description: String,
      picture:,

    });

// Export the model
module.exports = mongoose.model('UserReview', UserReviewSchema)
