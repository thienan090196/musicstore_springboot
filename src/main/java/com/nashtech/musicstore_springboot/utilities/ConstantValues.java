package com.nashtech.musicstore_springboot.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstantValues {
    public static final int PAGE_SIZE_ADMIN  = 10;

    public static final int PAGE_SIZE_USER = 12;

    public static final String ADMIN_ROLE = "Administrator";

    public static final String USER_ROLE = "User";

    public static final String DEFAULT_IMAGE_PATH = "resources/images/placeholder.gif";

    public static final String UPLOAD_DIRECTORY = "resources/uploads/";

    public static final List<String> LIST_IMAGE_TYPES = new ArrayList<String>(Arrays.asList("jpg", "jpeg", "gif", "png"));

    public static final long MAX_SIZE_UPLOAD = 5242880; //5MB

    public static final String CART_SESSION = "CART";
}
