package net.lz1998.demo.controller;

import net.lz1998.demo.entity.MyTest;
import net.lz1998.demo.repository.MyTestRepository;
import net.lz1998.demo.response.Response;
import net.lz1998.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/myTest")
@RestController
@CrossOrigin
public class MyTestController {
    @Autowired
    MyTestRepository myTestRepository;

    @Autowired
    UserService userService;

    @RequestMapping("/saveTest")
    public Response saveTest(MyTest myTest) {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        myTest.setUserId(userId);
        myTest.setTestId(UUID.randomUUID().toString());
        MyTest save = myTestRepository.save(myTest);
        return Response.getResponse(save);
    }

    @RequestMapping("/findTest")
    public Response findTest(@PageableDefault Pageable pageable) {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Page<MyTest> myTestPage = myTestRepository.findMyTestsByUserId(userId, pageable);
        return Response.getResponse(myTestPage);
    }

    @RequestMapping("/deleteTest")
    public Response deleteTest(String testId) {
        myTestRepository.deleteMyTestByTestId(testId);
        return Response.getResponse(true);
    }
}
