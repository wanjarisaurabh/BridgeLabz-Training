package com.streams.insuranceclaim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysisApp {
    public static void main(String[] args) {
        // sample insurance claims (as if from company database)
        List<Claim> claims = new ArrayList<>();
        claims.add(new Claim("CLM001", "Health", 125000.00, "Approved"));
        claims.add(new Claim("CLM002", "Motor", 45000.00, "Approved"));
        claims.add(new Claim("CLM003", "Health", 89000.00, "Pending"));
        claims.add(new Claim("CLM004", "Travel", 32000.00, "Approved"));
        claims.add(new Claim("CLM005", "Home", 180000.00, "Approved"));
        claims.add(new Claim("CLM006", "Motor", 72000.00, "Rejected"));
        claims.add(new Claim("CLM007", "Health", 210000.00, "Approved"));
        claims.add(new Claim("CLM008", "Life", 500000.00, "Approved"));
        claims.add(new Claim("CLM009", "Travel", 48000.00, "Approved"));
        claims.add(new Claim("CLM010", "Motor", 95000.00, "Approved"));
        claims.add(new Claim("CLM011", "Health", 65000.00, "Approved"));
        claims.add(new Claim("CLM012", "Home", 135000.00, "Pending"));

        System.out.println("Insurance Claim Analysis - Average Amount by Claim Type");
        System.out.println("-------------------------------------------------------------");

        // Stream: group by claim type -> average amount per group
        Map<String, Double> averageByType = claims.stream()
                .collect(Collectors.groupingBy(
                        Claim::getClaimType,                            // group by claim type
                        Collectors.averagingDouble(Claim::getAmount)    // compute average amount
                ));

        // Print results in sorted order by type
        averageByType.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.printf("%-10s : Average claim amount = Rs.%.2f%n",
                            entry.getKey(), entry.getValue());
                });

        System.out.println("-------------------------------------------------------------");
        System.out.println("Total claims analyzed: " + claims.size());
    }
}