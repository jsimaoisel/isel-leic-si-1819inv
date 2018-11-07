const express = require('express')
const app = express()

const port = 3001

app.get('/protectedresource', (req, resp) => {
    console.log(req.headers)
    if (req.header('Authorization')) {
        // TODO: check credentials
        console.log(req.header('Authorization'))
        resp.sendStatus(200)
    } else {
        resp.header(
            'WWW-Authenticate', 
            'Basic realm=testrealm')
        resp.sendStatus(401)    
    }
})

app.get('/printcookies', (req, resp) => {
    resp.statusCode = 200;
    resp.send(req.header('Cookie'))
})

app.get('/setcookies', (req, resp) => {
    resp.statusCode = 200;
    // eq. Set-Cookie: C1=A; C2=B; Path=/
    resp.setHeader('Set-Cookie', ['C1=A', 'C2=B']);
    resp.end()
})

const crypto = require('crypto');
const hmac = crypto.createHmac('sha256', 'changeit');

app.get('/setcookies-hmac', (req, resp) => {
    resp.statusCode = 200;
    // compute hmac 
    var h = hmac.digest('SomeRandomId')
    // convert to base64
    var hBase64 = Buffer.from(h).toString('base64');

    resp.setHeader('Set-Cookie', ['MyId=SomeRandomId', 'T='+hBase64]);

    resp.send('cookie *MyId* is protected by tag *T*')
})



app.listen(port, (err) => {
    if (err) {
        return console.log('something bad happened', err)
    }
    console.log(`server is listening on ${port}`)
})