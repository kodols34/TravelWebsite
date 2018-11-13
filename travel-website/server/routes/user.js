const usercontroller = require('./../controllers/user.ctrl')
const multipart = require('connect-multiparty')
const multipartWare = multipart()
module.exports = (router) => {
    /**
     * get all users
     */
    router
        .route('/users')
        .get(usercontroller.getAll)

    /**
     * add an user
     */
    router
        .route('/user')
        .post(multipartWare, usercontroller.addUser)

    /**
     * get a particlular user to view
     */
    router
        .route('/user/:id')
        .get(usercontroller.getUser)

    /**
    * update a particlular user
    */
    router
        .route('/user/:id/update')
        .put(usercontroller.updateUser)

    /**
    * delete a particlular user
    */
    router
        .route('/user/:id/delete')
        .delete(usercontroller.deleteUser)

}
