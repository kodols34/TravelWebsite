var mongoose = require('mongoose')
var UserReviewSchema = new mongoose.Schema({
      title: {
        type: String,
        required: true
      },
      user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'UserSchema',
        required: true
      },
      note: {
        type: Number,
        required: true,
        min: 0,
        max: 5
      },
      place: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Place',
        required: true
      },

      description: String,
      //picture:,

    });

// Export the model
module.exports = mongoose.model('UserReview', UserReviewSchema)
