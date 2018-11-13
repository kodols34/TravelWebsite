const Place = require('./../models/Place')
const fs = require('fs')
module.exports = {

    /**
     * get all places
     */
    getAll: (req, res, next) => {
      Place.find({}, function(err, places) {
          var placeMap = {};
          places.forEach(function(place) {
            placeMap[place._id] = place;
          });
          res.send(placeMap);
        });
    },

    /**
     * add a place
     */
    addPlace: (req, res, next) => {
      let place = new Place(
        {   nom: req.body.nom,
            note: req.body.note,
            rank: req.body.rank,
            address: req.body.address,
            description: req.body.description
        }
    );
    place.save(function (err) {
        if (err) {
            return next(err);
        }
        res.send(`Place Created successfully ${place}`)
    })

    },

    /**
     * get a particlular place to view
     */
    getPlace: (req, res, next) => {
      //res.send('Greetings from the Test controller!');
      Place.findById(req.params.id, function (err, place) {
        if (err) return next(err);
        res.send(place);
      })
    },

    /**
    * update a particlular place
    */
    updatePlace: (req, res, next) => {
      console.log(req.body);
      Place.findByIdAndUpdate(req.params.id, {$set: req.body}, function (err, place) {
        if (err) return next(err);
        res.send('Place udpated.');
      });
    },


    /**
    * delete a particlular place
    */
    deletePlace: (req, res, next) => {
      Place.findByIdAndRemove(req.params.id, function (err) {
        if (err) return next(err);
        res.send('Deleted successfully!');
      });
    }
}
