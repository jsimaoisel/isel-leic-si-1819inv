// content of index.js
const express = require('express')
const app = express()
const port = 3000

app.get('/secureresource', (request, response) => {
    console.log(request.headers)
    if (request.header('Authorization')) {
        // TODO: check credentials
        console.log(request.header('Authorization'))
        response.sendStatus(200)
    } else {
        response.header(
            'WWW-Authenticate', 
            'Basic realm=testrealm')
        response.sendStatus(401)    
    }
})

app.listen(port, (err) => {
    if (err) {
        return console.log('something bad happened', err)
    }
    console.log(`server is listening on ${port}`)
})