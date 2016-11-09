package com.tn.web.ctls;

import com.sun.javafx.scene.control.skin.ListViewSkin;
import com.tn.web.Exceptions.PositionException;
import com.tn.web.po.PositionMapping;
import com.tn.web.po.User;
import com.tn.web.repository.PositionMappingRepository;
import com.tn.web.repository.UserRepository;
import com.tn.web.requests.PositionReq;
import com.tn.web.responses.Latlng;
import com.tn.web.responses.PositionInfoResp;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Show on 2016/10/24.
 */
@RestController
@RequestMapping(path = "/Position")
public class PositionController {
    @Autowired
    private PositionMappingRepository positionMappingRepository;
    @Autowired
    private UserRepository userRepository;
    @PutMapping(path = "/updateMapping")
    public String updateMapping(){

        return "{}";
    }
    @PostMapping(path = "/getData")
    public List<PositionInfoResp> getData(@RequestParam(value="account",required = true) String account) throws PositionException{
        List<PositionInfoResp> result=new ArrayList<>();
        User user=userRepository.findByAccount(account);
        if(user==null)
            throw new PositionException(101,"This User does not exist.");
        List<PositionMapping> positionMappingList=positionMappingRepository.findAllByUser(user);
        for(PositionMapping positionMapping:positionMappingList){
            PositionInfoResp response =new PositionInfoResp();
            response.setAddress(positionMapping.getAddress());
            response.setLat(positionMapping.getLat());
            response.setLng(positionMapping.getLng());
            Latlng latLng = new Latlng();
            latLng.setLat(positionMapping.getLat());
            latLng.setLng(positionMapping.getLng());
            List<Latlng> latlng = Lists.newArrayList();
            latlng.add(latLng);
            response.setLatlng(latlng);
            response.setPlaceId(positionMapping.getPlace_id());
            response.setUserName(positionMapping.getUser().getName());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            response.setDateTime(sdf.format(positionMapping.getDatetime()));
            response.setDisplay(true);
            result.add(response);
        }
        return result;
    }
    @PutMapping(path = "/Add")
    @Transactional
    public String add(@RequestBody PositionReq positionReq) throws PositionException {
        User user=userRepository.findByAccount(positionReq.getAccount());
        if(user==null)
            throw new PositionException(101,"This User does not exist.");
        PositionMapping positionMapping=new PositionMapping();
        positionMapping.setLat(positionReq.getLat());
        positionMapping.setLng(positionReq.getLng());
        positionMapping.setPlace_id(positionReq.getPlace_id());
        positionMapping.setDatetime(positionReq.getDateTime());
        positionMapping.setAddress(positionReq.getAddress());
        positionMapping.setUser(user);
        positionMappingRepository.save(positionMapping);
        return "{}";
    }
}
