



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
