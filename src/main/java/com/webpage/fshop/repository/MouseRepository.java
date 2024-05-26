/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.repository;

import com.webpage.fshop.model.Mouse;
import com.webpage.fshop.model.Imageurl;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 04dkh
 */
@Repository
public interface MouseRepository extends JpaRepository<Mouse, String> {

    // Không cần khai báo ImageUrlRepository ở đây
    // Xóa phương thức không cần thiết getMouseById
    default List<Imageurl> getImageUrlsByMouseId(String mouseId) {
        Optional<Mouse> optionalMouse = findById(mouseId);
        return optionalMouse.map(Mouse::getimage_url).orElse(Collections.emptyList());
    }
    @Query(value = "SELECT COUNT(*) FROM Mouse")
    int getMouseCount();

    default Mouse saveWithDefaultId(Mouse mouse) {
        int count = getMouseCount() + 1;
        String defaultId = "mouse" + count;
        mouse.setId(defaultId);
        return save(mouse);
    }
}
