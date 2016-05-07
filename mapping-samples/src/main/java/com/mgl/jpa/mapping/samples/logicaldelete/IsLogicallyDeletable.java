package com.mgl.jpa.mapping.samples.logicaldelete;

import java.util.Date;

public interface IsLogicallyDeletable {

    boolean isDeleted();
    Date getDeletionTs();

}
