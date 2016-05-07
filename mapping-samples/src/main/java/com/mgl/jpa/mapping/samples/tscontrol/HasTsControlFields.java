package com.mgl.jpa.mapping.samples.tscontrol;

import java.util.Date;

public interface HasTsControlFields {

    Date getCreationTs();
    Date getLastModificationTs();

}
