const user = require('./user')
const place = require('./place')
const user_review = require('./user_review')
module.exports = (router) => {
    //user(router)
    place(router)
    user(router)
    user_review(router)
}
