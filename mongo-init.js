db.createUser(
    {
        user: "admin",
        pwd: "msdobot-soselab",
        roles: [
            {
                role: "readWrite",
                db: "msdobot"
            }
        ]
    }
);