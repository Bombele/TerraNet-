// src/nativeMain/kotlin/power/SmartPowerBridge.kt

package fardc.terranet.power

/**
 * Gère l'équilibre entre Récolte (Harvesting) et Consommation.
 */
class SmartPowerBridge {

    fun balanceEnergy() {
        val thermalEnergy = seebeckSensor.getOutput()
        val telluricEnergy = telluricProbe.collect()
        
        val totalPower = thermalEnergy + telluricEnergy
        
        if (totalPower > SYSTEM_NEED) {
            val surplus = totalPower - SYSTEM_NEED
            StorageUnit.store(surplus)
            LocalCommunityGrid.distribute(surplus) // L'énergie pour le village
        }
    }
}
