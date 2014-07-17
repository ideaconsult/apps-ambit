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
