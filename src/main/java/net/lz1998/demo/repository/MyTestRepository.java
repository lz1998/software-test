package net.lz1998.demo.repository;

import net.lz1998.demo.entity.MyTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MyTestRepository extends JpaRepository<MyTest, String> {
    Page<MyTest> findMyTestsByUserId(Long userId, Pageable pageable);
    @Transactional
    void deleteMyTestByTestId(String testId);
}
