package com.cxy.background.mapper;

import com.cxy.background.entity.ProductDesc;
import com.cxy.background.entity.ProductDescExample;
import com.cxy.background.entity.ProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDescMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int countByExample(ProductDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int deleteByExample(ProductDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int insert(ProductDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int insertSelective(ProductDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    List<ProductDesc> selectByExampleWithBLOBs(ProductDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    List<ProductDesc> selectByExample(ProductDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    ProductDesc selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ProductDesc record, @Param("example") ProductDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ProductDesc record, @Param("example") ProductDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ProductDesc record, @Param("example") ProductDescExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProductDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ProductDesc record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_desc
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProductDesc record);

    int updateByProductVo(ProductVo productVo);
}