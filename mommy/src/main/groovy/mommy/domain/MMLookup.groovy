package mommy.domain

import groovy.json.JsonSlurper

class MMLookup {
        static def makes = new JsonSlurper().parse(new File('mommy/src/main/resources/data.json'))
        static String getMake(String vin) {
                if (vin.length() < 3) {
                        return 'UNKNOWN'
                }
                if ( makes[vin[0..2]] != null) {
                        return makes[vin[0..2]][0]
                } else {
                        return "UNKNOWN"
                }
        }


}
