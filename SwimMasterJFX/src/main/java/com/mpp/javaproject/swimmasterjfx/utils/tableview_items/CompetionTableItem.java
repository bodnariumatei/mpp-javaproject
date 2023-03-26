package com.mpp.javaproject.swimmasterjfx.utils.tableview_items;

import com.mpp.javaproject.swimmasterjfx.domain.Competition;
import com.mpp.javaproject.swimmasterjfx.domain.CompetitionStyle;

public class CompetionTableItem extends Competition {
    private int noParticipants;

    public CompetionTableItem(int distance, CompetitionStyle style, int noParticipants) {
        super(distance, style);
        this.noParticipants = noParticipants;
    }

    public int getNoParticipants() {
        return noParticipants;
    }

    public void setNoParticipants(int noParticipants) {
        this.noParticipants = noParticipants;
    }
}
