EligibilityResult result = new EligibilityResult();

result.setLoanRequestId(loanRequest.getId());
result.setCalculatedEmi(emi);
result.setMaxAllowedEmi(maxAllowedEmi);

// ✅ Eligibility condition
boolean eligible = emi + profile.getEmi() <= maxAllowedEmi;
result.setEligible(eligible);

return result;
