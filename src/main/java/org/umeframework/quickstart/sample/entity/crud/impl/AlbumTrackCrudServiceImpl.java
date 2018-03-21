package org.umeframework.quickstart.sample.entity.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.umeframework.dora.bean.BeanValidator;
import org.umeframework.dora.transaction.TransactionRequired;
import org.umeframework.dora.service.BaseDBComponent;
import org.umeframework.quickstart.sample.entity.AlbumTrackDto;
import org.umeframework.quickstart.sample.entity.crud.AlbumTrackCrudService;

/**
 * 唱片曲目信息:ALBUM_TRACK CRUD service implementation.<br>
 *
 * @author UME-Generator
 */
@org.springframework.stereotype.Service
public class AlbumTrackCrudServiceImpl extends BaseDBComponent implements AlbumTrackCrudService {

    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#create
     */
    @Override
    @TransactionRequired
    public Integer create(AlbumTrackDto entity) {
        validate(entity);
        if (entity.getCreateAuthor() == null) {
            entity.setCreateAuthor(super.getUid());
        }
        if (entity.getUpdateAuthor() == null) {
            entity.setUpdateAuthor(super.getUid());
        }
        int result = super.getDao().update(AlbumTrackDto.SQLID.INSERT, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#createList
     */
    @Override
    @TransactionRequired
    public List<Integer> createList(List<AlbumTrackDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumTrackDto entity : entityList) {
            result.add(this.create(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#createOrUpdate
     */
    @Override
    @TransactionRequired
    public Integer createOrUpdate(AlbumTrackDto entity) {
        AlbumTrackDto existed = super.getDao().queryForObject(AlbumTrackDto.SQLID.FIND, entity, AlbumTrackDto.class);
        if (existed == null) {
            return this.create(entity);
        } else {
            validate(entity);
            return this.update(entity);
        }
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#createOrUpdateList
     */
    @Override
    @TransactionRequired
    public List<Integer> createOrUpdateList(List<AlbumTrackDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumTrackDto entity : entityList) {
            result.add(this.createOrUpdate(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#update
     */
    @Override
    @TransactionRequired
    public Integer update(AlbumTrackDto entity) {
        validate(entity);
        if (entity.getUpdateAuthor() == null) {
            entity.setUpdateAuthor(super.getUid());
        }
        int result = super.getDao().update(AlbumTrackDto.SQLID.SMART_UPDATE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#updateList
     */
    @Override
    @TransactionRequired
    public List<Integer> updateList(List<AlbumTrackDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumTrackDto entity : entityList) {
            result.add(this.update(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#updateFully
     */
    @Override
    @TransactionRequired
    public Integer updateFully(AlbumTrackDto entity) {
        validate(entity);
        int result = super.getDao().update(AlbumTrackDto.SQLID.UPDATE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#updateFullyList
     */
    @Override
    @TransactionRequired
    public List<Integer> updateFullyList(List<AlbumTrackDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumTrackDto entity : entityList) {
            result.add(this.updateFully(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#delete
     */
    @Override
    @TransactionRequired
    public Integer delete(AlbumTrackDto entity) {
        int result = super.getDao().update(AlbumTrackDto.SQLID.DELETE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#deleteList
     */
    @Override
    @TransactionRequired
    public List<Integer> deleteList(List<AlbumTrackDto> entityList) {
        List<Integer> result = new ArrayList<Integer>(entityList.size());
        for (AlbumTrackDto entity : entityList) {
            result.add(this.delete(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#find
     */
    @Override
    public AlbumTrackDto find(AlbumTrackDto queryParam) {
        return super.getDao().queryForObject(AlbumTrackDto.SQLID.FIND, queryParam, AlbumTrackDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#findList
     */
    @Override
    public List<AlbumTrackDto> findList(AlbumTrackDto condition) {
        return super.getDao().queryForObjectList(AlbumTrackDto.SQLID.FIND_LIST, condition, AlbumTrackDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#findListLike
     */
    @Override
    public List<AlbumTrackDto> findListLike(Map<String, String> condition) {
        return super.getDao().queryForObjectList(AlbumTrackDto.SQLID.FIND_LIST_LIKE, condition, AlbumTrackDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService#findListMatch
     */
    @Override
    public List<AlbumTrackDto> findListMatch(Map<String, String> dynaCondition) {
        return super.getDao().queryForObjectList(AlbumTrackDto.SQLID.FIND_LIST_MATCH, dynaCondition, AlbumTrackDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.sample.entity.crud.impl.AlbumTrackCrudService
     */
    @Override
    public Integer count(Map<String, String> condition) {
        return super.getDao().count(AlbumTrackDto.SQLID.COUNT, condition);
    }

    /**
     * Do entity validation before doUpdate
     * 
     * @param entity - Target doUpdate Entity
     */
    protected void validate(AlbumTrackDto entity) {
        // Here invoke the default entity check logic
        BeanValidator beanValidator = new BeanValidator();
        // Invoke validation rule
        beanValidator.validate(entity);
    }
}
