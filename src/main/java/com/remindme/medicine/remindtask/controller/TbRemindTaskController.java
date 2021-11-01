package com.remindme.medicine.remindtask.controller;


import com.remindme.medicine.common.utils.ResultVOUtil;
import com.remindme.medicine.common.utils.entity.response.ResultVO;
import com.remindme.medicine.remindtask.entity.param.RemindTaskSaveParamVO;
import com.remindme.medicine.remindtask.service.TbRemindTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 提醒任务表 前端控制器
 * </p>
 *
 * @author Kongql
 * @since 2021-10-24
 */
@RestController
@RequestMapping("/remindtask/tb-remind-task")
@Api(value = "提醒任务相关接口")
public class TbRemindTaskController {
        @Resource
        private TbRemindTaskService remindTaskService;

        @RequestMapping(value = "/saveRemindTask", method = RequestMethod.POST)
        @ResponseBody
        @ApiOperation(value = "保存提醒任务")
        public ResultVO<Boolean> saveRemindTask(@RequestBody RemindTaskSaveParamVO param, HttpServletRequest request){
                ResultVO<Boolean> res;
                boolean saved = false;
                try {
                  saved = remindTaskService.saveRemindTask(param);
                  res = ResultVOUtil.success(saved);
                }catch (Exception e){
                        e.printStackTrace();
                        res = ResultVOUtil.fail(saved);
                }
                return res;
        }

        @RequestMapping("/test")
        @ResponseBody
        @ApiOperation(value = "测试接口")
        public String test(HttpServletRequest request){
            return remindTaskService.getById("1").toString();
        }
}

