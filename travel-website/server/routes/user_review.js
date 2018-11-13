const user_review_controller = require('./../controllers/user_review.ctrl')
const multipart = require('connect-multiparty')
const multipartWare = multipart()
module.exports = (router) => {
    /**
     * get all reviews
     */
    router
        .route('/reviews')
        .get(user_review_controller.getAll)

    /**
     * add a review
     */
    router
        .route('/review')
        .post(multipartWare, user_review_controller.addReview)

    /**
     * get a particlular review to view
     */
    router
        .route('/review/:id')
        .get(user_review_controller.getReview)

    /**
    * update a particlular review
    */
    router
        .route('/review/:id/update')
        .put(user_review_controller.updateReview)

    /**
    * delete a particlular review
    */
    router
        .route('/review/:id/delete')
        .delete(user_review_controller.deleteReview)

}
