##Local Policy Administration Point

   [http://host:port/app/admin/restpolicy](http://host:port/app/admin/restpolicy)

### JSON

````json
{
    "policy": [
        {
            "uri": "http://host:port/app/admin/restpolicy/1",
            "resource": "/model",
            "role": "ambit_admin",
            "methods": {
                "get": true,
                "post": true,
                "put": true,
                "delete": true
            }
        },
        {
            "uri": "http://host:port/app/admin/restpolicy/2",
            "resource": "/dataset",
            "role": "ambit_admin",
            "methods": {
                "get": true,
                "post": true,
                "put": true,
                "delete": true
            }
        }
    ]
}
````

###REST Operations

#### GET /admin/restpolicy 
Returns all policies (JSON as above)

#### GET /admin/restpolicy/{id}
Returns one policy (JSON as above).

#### PUT /admin/restpolicy/{id}
Updates one policy.  Returns a task URI

Expects Content-type:[application/x-www-form-urlencoded](http://www.w3.org/TR/html401/interact/forms.html#h-17.13.4.1) with the following fields (all fields optional, unspecified fields will not be updated):

````
<form method="POST" action="/admin/restpolicy" enctype='application/x-www-form-urlencoded'>
 <input type=text name="role">
 <input type=text name="resource">
 <input type=checkbox name="get">
 <input type=checkbox name="post">
 <input type=checkbox name="delete">
 <input type=checkbox name="put">
 <input type=submit name="submit" value=" OK ">
</form>
````

#### DELETE /admin/restpolicy/{id}
Deletes one policy.  Returns a task URI.

#### POST /admin/restpolicy
Creates a new policy. Returns a task URI.
Expects Content-type:[application/x-www-form-urlencoded](http://www.w3.org/TR/html401/interact/forms.html#h-17.13.4.1) with the following fields (role and resource fields mandatory, unspecified method fields will be assigned 'false'):

````
<form method="POST" action="/admin/restpolicy" enctype='application/x-www-form-urlencoded'>
 <input type=text name="role">
 <input type=text name="resource">
 <input type=checkbox name="get">
 <input type=checkbox name="post">
 <input type=checkbox name="delete">
 <input type=checkbox name="put">
 <input type=submit name="submit" value=" OK ">
</form>
````

##### [cURL](http://curl.haxx.se/) example

````
curl -X POST http://host:port/app/admin/restpolicy -H "Accept:application/json" -d"role=ambit_user" -d"resource=/ambit2/model/123" -i
HTTP/1.1 202 Accepted
Content-Language: en
Date: Thu, 17 Jul 2014 15:53:24 GMT
Vary: Accept-Charset, Accept-Encoding, Accept-Language, Accept
Accept-Ranges: bytes
Access-Control-Allow-Origin: *
Access-Control-Allow-Methods: GET,POST,PUT,DELETE,OPTIONS
Access-Control-Allow-Headers: Content-Type
Access-Control-Allow-Credentials: true
Access-Control-Max-Age: 60
Content-Type: application/json;charset=UTF-8
Content-Length: 522

{"task": [
{
        "uri":"http://host:port/app/task/1c545da3-bc36-4c58-8d1f-ad2d4f05e07f",
        "id": "Started Thu Jul 17 18:53:24 EEST 2014 Completed ",
        "name": "Apply  to XYZ",
        "error": "",
        "policyError": "",
        "status": "Running",
        "started": 1405612404938,
        "completed": -1,
        "result": "http://host:port/app/task/1c545da3-bc36-4c58-8d1f-ad2d4f05e07f",
        "user": ""
}
]
}

````


### List of roles

#### GET /admin/role

````json
   {
       "roles": [
           "test_role",
           "test_admin"
       ]
   }
````
