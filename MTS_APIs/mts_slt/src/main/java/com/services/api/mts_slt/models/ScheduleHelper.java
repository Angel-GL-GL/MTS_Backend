package com.services.api.mts_slt.models;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//Clase solamente para ayuda en los json de horarios
public class ScheduleHelper {
    private ArrayList<RouteHelper> routeHelpers;
    private ArrayList<Schedules> schedules;

    public ScheduleHelper(){
        routeHelpers = new ArrayList<>();
        schedules = new ArrayList<>();
    }

    public void add(RouteHelper rh){routeHelpers.add(rh);}

    public void add(List<Schedules> sc){
        for(Schedules s:sc) schedules.add(s);
    }
}
