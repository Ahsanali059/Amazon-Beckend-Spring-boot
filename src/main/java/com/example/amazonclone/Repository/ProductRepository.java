package com.example.amazonclone.Repository;

import com.example.amazonclone.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>
{
    //Additional product query if required

}
