import com.example.demo.entity.LoanRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@PostMapping
public LoanRequest submit(@RequestBody LoanRequest request) {
    return service.submitLoanRequest(request);
}

@GetMapping("/user/{userId}")
public List<LoanRequest> getByUser(@PathVariable Long userId) {
    return service.getRequestsByUser(userId);
}
