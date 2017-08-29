package com.budjb.vmworld

import grails.transaction.Transactional

@Transactional
class NetworkStatsService {
    static class NetworkStats {
        String hostname
        List<String> ipAddresses = []
    }

    NetworkStats getCurrentNetworkStats() {
        NetworkStats networkStats = new NetworkStats()

        networkStats.hostname = 'hostname'.execute().text
        NetworkInterface.getNetworkInterfaces().each {
            it.getInetAddresses().each {
                networkStats.ipAddresses.add(it.getHostAddress())
            }
        }

        return networkStats
    }
}
