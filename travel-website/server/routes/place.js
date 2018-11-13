const placecontroller = require('./../controllers/place.ctrl')
const multipart = require('connect-multiparty')
const multipartWare = multipart()
module.exports = (router) => {
    /**
     * get all places
     */
    router
        .route('/places')
        .get(placecontroller.getAll)

    /**
     * add an article
     */
    router
        .route('/place')
        .post(multipartWare, placecontroller.addPlace)

    /**
     * get a particlular place to view
     */
    router
        .route('/place/:id')
        .get(placecontroller.getPlace)

    /**
    * update a particlular place
    */
    router
        .route('/place/:id/update')
        .put(placecontroller.updatePlace)

    /**
    * delete a particlular place
    */
    router
        .route('/place/:id/delete')
        .delete(placecontroller.deletePlace)

}
