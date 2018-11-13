const UserReview = require('./../models/UserReview')
const fs = require('fs')
module.exports = {

    /**
     * get all review
     */
    getAll: (req, res, next) => {
      UserReview.find({}, function(err, reviews) {
          var reviewMap = {};
          reviews.forEach(function(review) {
            reviewMap[review._id] = review;
          });
          res.send(reviewMap);
        });
    },

    /**
     * add a review
     */
    addReview: (req, res, next) => {
      let review = new UserReview(
        {   title: req.body.title,
            user: req.body.user,
            note: req.body.note,
            place: req.body.place,
            description: req.body.description,
            //picture:
        }
    );
    review.save(function (err) {
        if (err) {
            return next(err);
        }
        res.send(`Review Created successfully ${review}`)
    })

    },

    /**
     * get a particlular review
     */
    getReview: (req, res, next) => {
      //res.send('Greetings from the Test controller!');
      UserReview.findById(req.params.id, function (err, review) {
        if (err) return next(err);
        res.send(review);
      })
    },

    /**
    * update a particlular review
    */
    updateReview: (req, res, next) => {
      console.log(req.body);
      UserReview.findByIdAndUpdate(req.params.id, {$set: req.body}, function (err, review) {
        if (err) return next(err);
        res.send('Review udpated.');
      });
    },


    /**
    * delete a particlular review
    */
    deleteReview: (req, res, next) => {
      UserReview.findByIdAndRemove(req.params.id, function (err) {
        if (err) return next(err);
        res.send('Deleted successfully!');
      });
    }
}
