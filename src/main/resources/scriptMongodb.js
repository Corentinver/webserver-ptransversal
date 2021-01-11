// A executer dans un invite de commande
// Pour executer : mongo < scriptMongodb.js 

use simulator
db.dropDatabase()
use simulator

// Création des tables 
db.createCollection("FireStation")
db.createCollection("FireFighter")
db.createCollection("Operation")
db.createCollection("Fire")
db.createCollection("TypeVehicle")
db.createCollection("Vehicle")
db.createCollection("J_TVehicle_TFire")
db.createCollection("TypeFire")
db.createCollection("Sensor")

// Insertions des casernes
db.FireStation.insertMany([
    {
        location: {
            latitude: 45.7627835,
            longitude: 4.8439261
        },
        name: "Centre d'intervention Lyon Corneille"
    },
    {
        location: {
            latitude: 45.7468624,
            longitude: 4.8258056
        },
        name: "Caserne Lyon-Confluence"
    },
    {
        location: {
            latitude: 45.7453184,
            longitude: 4.8487721
        },
        name: "Centre d'intervention Lyon Rochat"
    },
    {
        location: {
            latitude: 45.762685,
            longitude: 4.8445398
        },
        name: "(CASC) Des Sapeurs-pompiers"
    },
    {
        location: {
            latitude: 45.7316551,
            longitude: 4.8284384
        },
        name: "Caserne Lyon - Gerland"
    },
    {
        location: {
            latitude: 45.7908319,
            longitude: 4.7979497
        },
        name: "Sdis Du Rhône"
    },
    {
        location: {
            latitude: 45.7793121,
            longitude: 4.8205089
        },
        name: "Centre d'intervention Lyon Croix-Rousse"
    }])

// Insertion FireFighter

var fireStations = db.FireStation.find();

var fireStationsId = fireStations.map(element => element._id);

var fireFighters = [
    {
        name: "John Newton"
    },
    {
        name: "Samuel Forain"
    },
    {
        name: "Emanuel Ronflant"
    },
    {
        name: "Jack Daniel"
    },
    {
        name: "Henry Fiat"
    },
    {
        name: "Gwendal Pichet"
    },
    {
        name: "Jean Charles"
    },
    {
        name: "Renaud Lance"
    },
    {
        name: "Emma Voisine"
    },
    {
        name: "Daniel Truck"
    },
    {
        name: "Damien Velo"
    },
    {
        name: "Michel Despeches"
    },
    {
        name: "Kevin Dupont"
    },
    {
        name: "Kevin Dupont"
    },
    {
        name: "Jean-michel Javou"
    },
    {
        name: "Christine Flau"
    },
    {
        name: "Christian Route"
    },
    {
        name: "Sam Hira"
    },
    {
        name: "Xavier Clavier"
    },
    {
        name: "Jeanne Eau"
    },
    {
        name: "François Belge"
    }
];


var id = 0;
var insertCompteur = 0;
fireFighters.forEach(fireFighter => {
    insertFighter = {
        ...fireFighter,
        idFireStation: fireStationsId[id]
    };

    insertCompteur++;
    if (insertCompteur == 3) {
        insertCompteur = 0;
        id++;
    }
    db.FireFighter.insert(insertFighter);
});


// Insert Type Vehicle

db.TypeVehicle.insertMany([
    {
        name: "Fourgon Pompe Tonne Secours Routier",
        tag: "FPT"
    },
    {
        name: "Camion-citerne feux de forêts",
        tag: "CCF"
    },
    {
        name: "EPA (échelle pivotante automatique)",
        tag: "EPA"
    },
]
)


// Insert Vehicle


var fireStations = db.FireStation.find();

fireStations.forEach(fireStation => {
    var typeVehicles = db.TypeVehicle.find();
    typeVehicles.forEach(type => {
        insertVehicle = {
            idType: type._id,
            idFireStation: fireStation._id
        };
        db.Vehicle.insert(insertVehicle);
        db.Vehicle.insert(insertVehicle);
    });
})


// Insert Sensor

db.Sensor.insertMany([{
    location: {
        latitude: 45.7947846,
        longitude: 4.8177336
    },
    name: "D1"
},
{
    location: {
        latitude: 45.8006755,
        longitude: 4.8280607
    },
    name: "E1"
},
{
    location: {
        latitude: 45.8027029,
        longitude: 4.8372888
    },
    name: "F1"
},
{
    location: {
        latitude: 45.7837218,
        longitude: 4.7923363
    },
    name: "B2"
},
{
    location: {
        latitude: 45.7825458,
        longitude: 4.8027130
    },
    name: "C2"
},
{
    location: {
        latitude: 45.7843456,
        longitude: 4.8156562
    },
    name: "D2"
},
{
    location: {
        latitude: 45.7828446,
        longitude: 4.8285937
    },
    name: "E2"
},
{
    location: {
        latitude: 45.7785488,
        longitude: 4.8405696
    },
    name: "F2"
},
{
    location: {
        latitude: 45.7794271,
        longitude: 4.8538277
    },
    name: "G2"
},
{
    location: {
        latitude: 45.7643168,
        longitude: 4.7914648
    },
    name: "B3"
},
{
    location: {
        latitude: 45.7684026,
        longitude: 4.8035261
    },
    name: "C3"
},
{
    location: {
        latitude: 45.7661873,
        longitude: 4.8153278
    },
    name: "D3"
}])

db.Sensor.insertMany([{
    location: {
        latitude: 45.7663071,
        longitude: 4.8281595
    },
    name: "E3"
},
{
    location: {
        latitude: 45.7660975,
        longitude: 4.8419353
    },
    name: "F3"
},
{
    location: {
        latitude: 45.7661574,
        longitude: 4.8539945
    },
    name: "G3"
},
{
    location: {
        latitude: 45.7639645,
        longitude: 4.8651898
    },
    name: "H3"
},
{
    location: {
        latitude: 45.7512947,
        longitude: 4.7809524
    },
    name: "A4"
},
{
    location: {
        latitude: 45.7515697,
        longitude: 4.7889778
    },
    name: "B4"
},
{
    location: {
        latitude: 45.7534946,
        longitude: 4.8014817
    },
    name: "C4"
},
{
    location: {
        latitude: 45.7535946,
        longitude: 4.8157053
    },
    name: "D4"
},
{
    location: {
        latitude: 45.7500447,
        longitude: 4.8277434
    },
    name: "E4"
},
{
    location: {
        latitude: 45.7492697,
        longitude: 4.8413938
    },
    name: "F4"
},
{
    location: {
        latitude: 45.7495947,
        longitude: 4.8533244
    },
    name: "G4"
},
{
    location: {
        latitude: 45.7487947,
        longitude: 4.8677630
    },
    name: "H4"
}])

db.Sensor.insertMany([{
    location: {
        latitude: 45.7471696,
        longitude: 4.8799444
    },
    name: "I4"
},
{
    location: {
        latitude: 45.7481197,
        longitude: 4.8900837
    },
    name: "J4"
},
{
    location: {
        latitude: 45.7371516,
        longitude: 4.8173135
    },
    name: "D5"
},
{
    location: {
        latitude: 45.7325437,
        longitude: 4.8294026
    },
    name: "E5"
}])

db.Sensor.insertMany([{
    location: {
        latitude: 45.7337978,
        longitude: 4.8397232
    },
    name: "F5"
},
{
    location: {
        latitude: 45.7328975,
        longitude: 4.8537319
    },
    name: "G5"
},
{
    location: {
        latitude: 45.7317972,
        longitude: 4.8663074
    },
    name: "H5"
},
{
    location: {
        latitude: 45.7311469,
        longitude: 4.8778439
    },
    name: "I5"
},
{
    id: 033,
    location: {
        latitude: 45.7363235,
        longitude: 4.8868725
    },
    name: "J5"
},
{
    location: {
        latitude: 45.7226331,
        longitude: 4.8218863
    },
    name: "D6"
},
{
    location: {
        latitude: 45.7175202,
        longitude: 4.8283346
    },
    name: "E6"
}])

db.Sensor.insertMany([{
    location: {
        latitude: 45.7204719,
        longitude: 4.8408744
    },
    name: "F6"
},
{
    location: {
        latitude: 45.7221478,
        longitude: 4.8515868
    },
    name: "G6"
},
{
    location: {
        latitude: 45.7231983,
        longitude: 4.8816821
    },
    name: "I6"
},
{
    location: {
        latitude: 45.7215725,
        longitude: 4.8869488
    },
    name: "J6"
}])

// Insert TypeFire
db.TypeFire.insertMany([
    {
        name: "feu maison",
        number: 0
    },
    {
        name: "feu immeuble",
        number: 1
    },
    {
        name: "feu de forêt",
        number: 2
    },
    {
        name: "feu industriel",
        number: 3
    }
])

var typeFires = db.TypeFire.find()
var typeVehicles = db.TypeVehicle.find()
var arrayVehicles = []


typeVehicles.forEach(type => {
    arrayVehicles.push(type)
})

typeFires.forEach(typeFire => {
    switch(typeFire.number){
        case 0 :

            insertJ_Vehicle_Fire_Type = {
                idVehicleType : arrayVehicles.filter(type => type.tag == "FPT")[0]._id,
                idFireType : typeFire._id
            }

            db.J_TVehicle_TFire.insert(insertJ_Vehicle_Fire_Type)
            break;
        case 1 :
            insertJ_Vehicle_Fire_Type1 = {
                idVehicleType : arrayVehicles.filter(type => type.tag == "FPT")[0]._id,
                idFireType : typeFire._id
            }

            insertJ_Vehicle_Fire_Type2 = {
                idVehicleType : arrayVehicles.filter(type => type.tag == "EPA")[0]._id,
                idFireType : typeFire._id
            }

            db.J_TVehicle_TFire.insert(insertJ_Vehicle_Fire_Type1)
            db.J_TVehicle_TFire.insert(insertJ_Vehicle_Fire_Type2)
            break;
        case 2 :
            insertJ_Vehicle_Fire_Type = {
                idVehicleType : arrayVehicles.filter(type => type.tag == "CCF")[0]._id,
                idFireType : typeFire._id
            }

            db.J_TVehicle_TFire.insert(insertJ_Vehicle_Fire_Type)
            break;
        case 3 :
            insertJ_Vehicle_Fire_Type = {
                idVehicleType : arrayVehicles.filter(type => type.tag == "FPT")[0]._id,
                idFireType : typeFire._id
            }

            db.J_TVehicle_TFire.insert(insertJ_Vehicle_Fire_Type)
            break;
    }
    
})


