@PostMapping
public LoanRequest submit(@RequestBody LoanRequest request) {
    return service.submitLoanRequest(request);
}

@GetMapping("/user/{userId}")
public List<LoanRequest> getByUser(@PathVariable Long userId) {
    return service.getRequestsByUser(userId);
}
