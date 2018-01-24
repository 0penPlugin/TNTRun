package com.openplugins.tntrun.utils;

import org.bukkit.Location;

import java.util.HashSet;
import java.util.Set;

public abstract class StorageAPI {

    private static Set<Location> removedBlocks;

    public static void init() {
        removedBlocks = new HashSet<>();
    }

    public static Set<Location> getRemovedBlocks() {
        return removedBlocks;
    }
}
