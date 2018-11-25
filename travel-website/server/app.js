/** require dependencies */
const express = require("express")
const routes = require('./routes/')
const cors = require('cors')
const bodyParser = require('body-parser')
const helmet = require('helmet')
const db = require('./models/db.js')

const app = express()
const router = express.Router()


let port = 5000 || process.env.PORT

/** set up routes {API Endpoints} */
routes(router)

/** set up middlewares */
app.use(cors())
app.use(bodyParser.json()) // support json encoded bodies
app.use(bodyParser.urlencoded({ extended: true })); // support encoded bodies
app.use(helmet())
//app.use('/static',express.static(path.join(__dirname,'static')))

app.use('/api', router)

/** start server */
app.listen(port, () => {
    console.log(`Server started at port: ${port}`);
});
