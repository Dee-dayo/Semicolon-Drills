package geopoliticalZone;

public class GeopoliticalZoneCheck {
    public static GeopoliticalZone checkZone(String state) {
        for (GeopoliticalZone zone: GeopoliticalZone.values()){
            for (String zoneState: zone.getStates()) {
                if (zoneState.equalsIgnoreCase(state)) return zone;
            }
        }
        return null;
    }

    public static GeopoliticalZone checkZoneTakeTwo(String state) {
        return getGeopoliticalZone(state);
    }

    public static GeopoliticalZone checkZoneTakeThree(String state) {
        GeopoliticalZone[] zones = GeopoliticalZone.values();
        for (int index = 0; index < zones.length; index++) {
            GeopoliticalZone zone = zones[index];
            for (int states = 0; states < zone.getStates().length; states++){
                if (zone.getStates()[states].equalsIgnoreCase(state)) return zone;
            }
        }
        return null;
    }

    private static GeopoliticalZone getGeopoliticalZone(String state) {
        for (GeopoliticalZone zone: GeopoliticalZone.values()){
            GeopoliticalZone zone1 = getGeopoliticalZone(state, zone);
            if (zone1 != null) return zone1;
        }
        return null;
    }

    private static GeopoliticalZone getGeopoliticalZone(String state, GeopoliticalZone zone) {
        for (String zoneState: zone.getStates()) {
            if (isZone(state, zoneState)) return zone;
        }
        return null;
    }

    private static boolean isZone(String state, String zoneState) {
        return zoneState.equalsIgnoreCase(state);
    }


}
