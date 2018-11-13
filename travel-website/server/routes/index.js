const user = require('./user')
const article = require('./article')
const place = require('./place')
module.exports = (router) => {
    //user(router)
    article(router)
    place(router)
    user(router)
}
