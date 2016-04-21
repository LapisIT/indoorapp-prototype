cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/cordova-plugin-whitelist/whitelist.js",
        "id": "cordova-plugin-whitelist.whitelist",
        "runs": true
    },
    {
        "file": "plugins/sv-plugins-indooratlas/www/IndoorAtlas.js",
        "id": "sv-plugins-indooratlas.IndoorAtlas",
        "clobbers": [
            "indooratlas"
        ]
    },
    {
        "file": "plugins/onesignal-cordova-plugin/www/OneSignal.js",
        "id": "onesignal-cordova-plugin.OneSignal",
        "clobbers": [
            "OneSignal"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-whitelist": "1.2.1",
    "sv-plugins-indooratlas": "1.0.0",
    "onesignal-cordova-plugin": "1.12.3"
};
// BOTTOM OF METADATA
});