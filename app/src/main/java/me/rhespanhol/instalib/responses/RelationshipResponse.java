package me.rhespanhol.instalib.responses;

import com.google.gson.annotations.SerializedName;

import me.rhespanhol.instalib.enums.IncomingRelationship;
import me.rhespanhol.instalib.enums.OutgoingRelationship;

/**
 * Created by rhespanhol on 14/09/15.
 */
public class RelationshipResponse {

    @SerializedName("target_user_is_private")
    private boolean privateTargetUser;

    @SerializedName("outgoing_status")
    private OutgoingRelationship outgoingRelationship;

    @SerializedName("incoming_status")
    private IncomingRelationship incomingRelationship;

    public boolean isPrivateTargetUser() {
        return privateTargetUser;
    }

    public void setPrivateTargetUser(boolean privateTargetUser) {
        this.privateTargetUser = privateTargetUser;
    }

    public OutgoingRelationship getOutgoingRelationship() {
        return outgoingRelationship;
    }

    public void setOutgoingRelationship(OutgoingRelationship outgoingRelationship) {
        this.outgoingRelationship = outgoingRelationship;
    }

    public IncomingRelationship getIncomingRelationship() {
        return incomingRelationship;
    }

    public void setIncomingRelationship(IncomingRelationship incomingRelationship) {
        this.incomingRelationship = incomingRelationship;
    }
}
