package com.kdw.board.common.util;

// import org.quartz.CronScheduleBuilder;
// import org.quartz.Job;
// import org.quartz.JobBuilder;
// import org.quartz.JobDetail;
// import org.quartz.JobExecutionContext;
// import org.quartz.JobExecutionException;
// import org.quartz.ScheduleBuilder;
// import org.quartz.Trigger;
// import org.quartz.TriggerBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.stereotype.Component;

// @Component
// public class SampleJob implements Job {
    
//     @Override
//     public void execute(JobExecutionContext context) throws JobExecutionException {
//         System.out.println("SampleJob excute!!");
//     }

//     @Bean
//     public JobDetail jobDetail(){
//         return JobBuilder
//         .newJob()
//         .ofType(SampleJob.class)
//         .storeDurably()
//         .withIdentity("TEST JOB DETAIL")
//         .withDescription("Sample Job Detail 테스트입니다.")
//         .build();
//     }

//     @Bean
//     public Trigger trigger(JobDetail jobDetail){

//         CronScheduleBuilder cronScedule = CronScheduleBuilder.cronSchedule("2 * * * * ?");
//         return TriggerBuilder
//         .newTrigger()
//         .forJob(jobDetail)
//         .withIdentity("TEST SAMPLE TRIGGER")
//         .withDescription("SAMPLE TRIGGER TEST입니다.")
//         .withSchedule(cronScedule)
//         .build();
//     }
// }
