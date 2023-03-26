package com.mpp.javaproject.swimmasterjfx.repository.participant;

import com.mpp.javaproject.swimmasterjfx.domain.Participant;
import com.mpp.javaproject.swimmasterjfx.repository.IRepository;

public interface IParticipantRepository extends IRepository<Integer, Participant> {
    /**
     * Finds a participant with given name
     * @param name - the name of the participant to be found
     *           - must not be null
     * @return  - the entity with the given name if it exists
     *          - null if the participant does not exist
     */
    public Participant getOneByName(String name);

    public Iterable<Participant> getAllFromCompetition(int competition_id);
}
