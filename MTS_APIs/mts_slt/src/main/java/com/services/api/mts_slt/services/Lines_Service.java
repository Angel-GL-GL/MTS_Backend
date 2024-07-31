package com.services.api.mts_slt.services;

import com.services.api.mts_slt.models.Lines;
import com.services.api.mts_slt.repositories.Lines_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class Lines_Service {
    @Autowired
    private Lines_Repository repository;
}
