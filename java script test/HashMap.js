var HashMap = function() {
    let map = {};
    return {
        put: function(key, value) {
            map[key] = value; //map.key === map['key']
        },
        keys: function() {
            const keySet = [];
            for (let key in map) {
                keySet.push(key);
            }
            return keySet;
        },
        contains: function(key) {
            /*let isHas;
            for (let k in map) {
                if (k === key) {
                    isHas = true;
                    break;
                }else{
                    isHas = false
                }
            }
            return isHas;*/
            
            for (let k in map) {
                if (k === key) {
                    return true;
                }
            }
            return false;
        },
        get: function(key) {
            return map[key];
        },
        clear: function() {
            map = {};
        }
        // ,
        // all: function(key,value){
            
        // }
    };
};